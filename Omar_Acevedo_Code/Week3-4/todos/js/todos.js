$(document).ready(function() {
    
    $('#addTodo').click(function() {
        var newItemText = $('#newItem').val();
        var elementLI = document.createElement("li");
        elementLI.innerHTML = newItemText;
        $("#toBuy").append(elementLI);
        $('#newItem').val('');
    });

    // for each item
// v1
    // for (var i = 0; i < $('#toBuy li').length; i++) {

    //     // console.log($('#toBuy li')[i]);

    //     $('#toBuy li')[i].addEventListener("click", function() {
    //         var toDoItem = $(this).text();
    //         moveToPurchased(toDoItem);
    //         $(this).remove($('#toBuy li')[i]);
    //     });

    // }
    

// v2
    // $('#toBuy').on('click', 'li', function() {
    //     var toDoItem = $(this).text();
    //     moveToPurchased(toDoItem);
    //     $(this).remove($('#toBuy li'));
    // });

    // function moveToPurchased(toDoItem) {

    //     var elementLI = document.createElement("li");
    //     elementLI.innerHTML = toDoItem;

    //     $("#purchased").append(elementLI);

    // }
    
//  v3
    $('#toBuy').on('click', 'li', function() {
        $('#purchased').append(this);
    });

});