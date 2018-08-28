export enum ReimbursementType {
  Lodging = 'LODGING',
  Travel = 'TRAVEL',
  Food = 'FOOD',
  Other = 'OTHER',
}

export namespace ReimbursementType {
  /**
   * Parses a ReimbursementType from a string.
   *
   * @param s the string to be parsed as a (case-insensitive) type value
   */
  export function parse(s: string): ReimbursementType | null {
    switch (s.toLowerCase()) {
      case 'lodging':
        return ReimbursementType.Lodging;
      case 'travel':
        return ReimbursementType.Travel;
      case 'food':
        return ReimbursementType.Food;
      case 'other':
        return ReimbursementType.Other;
      default:
        return null;
    }
  }
}
