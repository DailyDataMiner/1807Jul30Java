function doSomethingWhenDocumentIsReady() {
    
    $.ajax({
        url: 'https://swapi.co/api/planets/1', 
        type: "get",
        success: function(data) {
            console.log(data);
        },
        error: function(err_data) {
            console.log(err_data);
        }
    });
    
    print('We are inside a callable function... - Called from the jQuery API ready function.');

    $('#executeFn').click(doSomethingCallbackFn);

    var bookObj = {
        id: 4,
        isbn: 29004,
        title: 'Book Title',
        price: 9.99,
        genre: 'A Genre'
    };


    function doSomethingCallbackFn() {

        setTimeout(getSomeData, 5000)

        print('A callback fucntion was just called from the jQuery API click function.\n');
        var myArr = [ 'raton', 'botella de agua', bookObj, 28, '1990' ];

        print("\nThis is an array -> ");
        print(myArr);
        print("\n");    

//      We are executing the forEach array fn
        myArr.forEach(myCallBackFn);
        
        function myCallBackFn(myIndex, myValue) {
            print(myIndex + ': ' +myValue);
        }
    
//        bookObj.open(1);

    }

    // bookObj.open = function(read) {
    //     console.log('...'+read);
    // };


    // function read(pageNum) {
    //     console.log('We are reading a page in page number ' + pageNum);
    // }
    

    function getSomeData() {
        console.log(111);
    }

//  Helper
    function print(p_value) {
        console.log(p_value);
    }
}