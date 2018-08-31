import { CanActivate, ActivatedRouteSnapshot, Router, RouterStateSnapshot } from '@angular/router';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { AuthService } from './auth/auth.service';
import { take, switchMap, catchError, mapTo, map } from 'rxjs/operators';
import { UserRole } from '../models/user-role.enum';

@Injectable()
export class AccessGuard implements CanActivate {
    constructor(private authService: AuthService, private router: Router) { }

    // RouterStateSnapshot to cache the url attempted to be accessed on the auth service
    // after user logs in, use this url to direct them to the page they want
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
        const requiresLogin = route.data.requiresLogin || false;
        const requiresAdmin = route.data.requiresAdmin || false;
        if (requiresAdmin) {
            return this.authService.getCurrentUser().pipe(
                map(user => {
                    if (user.role === UserRole.Manager) {
                        console.log('route guard admin access granted');
                        return true;
                    }
                    console.log('go home xD');
                    this.router.navigate(['home']);
                    return false;
                }),
                catchError(() => {
                    this.router.navigate(['login']);
                    return of(false);
                })
            );
        } else if (requiresLogin) {
            return this.authService.getCurrentUser().pipe(
                mapTo(true), // user not null, let access
                catchError(() => { // 404 error, return
                    this.router.navigate(['login']);
                    return of(false);
                })
            );
        }
    }
}
