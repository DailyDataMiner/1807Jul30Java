// JQUERY PRACTICE
$(document).ready(function(){
    $("#evenSubmit").on("click", function() {
        $("#evenOutput").text(isEven(parseInt($("#evenInput").val())));
    });

    $("#palindromeSubmit").on("click", function() {
        $("#palindromeOutput").text(isPalindrome($("#palindromeInput").val().split("")));
    });
});

function isPalindrome(input) {
    for (let i = 0; i < input.length - 1; i++) {
        if (input[i] !== input[input.length - 1 - i]) return false;
    }
    return true;
}

function isEven(input) {
    return input % 2 === 0;
}