// JQUERY PRACTICE
$(document).ready(function () {
    $("#evenSubmit").on("click", () => {
        $("#evenOutput").text(isEven(parseInt($("#evenInput").val())));
    });

    $("#palindromeSubmit").on("click", () => {
        $("#palindromeOutput").text(isPalindrome($("#palindromeInput").val().split("")));
    });

    $("#printSubmit").on("click", () => {
        $("#printOutput").text(printShape($("#printShape").val(), $("#printHeight").val(), $("#printCharacter").val()));
        $("#q8-draw-area").removeClass("d-none");
    });

    $("#q8-draw-area").on("click", () => {
        $("#q8-draw-area").addClass("d-none");
    })

    setInterval(() => {
        $("#currentTime").text(new Date().toLocaleTimeString());
    }, 1);

    $("#descSubmit").on("click", () => {
        $("#descOutput").text(descending($("#descInput").val()));
    });
});

function descending(input) {
    let output = input
        .split("")
        .map(Number)
        .sort((a, b) => b - a);

    return parseInt(output.join(""));
}

function isPalindrome(input) {
    for (let i = 0; i < input.length - 1; i++) {
        if (input[i] !== input[input.length - 1 - i]) return false;
    }
    return true;
}

function isEven(input) {
    return input % 2 === 0;
}

function printShape(shape, height, character) {
    let input = shape.toLowerCase();
    let output = "";
    switch (input) {
        case ("square"):
            output = printSquare(height, character);
            break;
        case ("triangle"):
            output = printTriangle(height, character);
            break;
        case ("diamond"):
            output = printDiamond(height, character);
            break;
    }
    return output;
}

function printSquare(height, character) {
    let output = "";
    for (let i = 0; i < height; i++) {
        for (let j = 0; j < height; j++) {
            output += character;
        }
        output += "\n";
    }
    return output;
}

function printTriangle(height, character) {
    let output = "";
    for (let i = 1; i <= height; i++) {
        for (let j = 1; j <= i; j++) {
            output += character;
        }
        output += "\n";
    }
    return output;
}

function printDiamond(height, character) {
    let output = "";
    let space = height - 1;
    for (let i = 1; i <= height; i++) {
        for (let j = 1; j <= space; j++) {
            output += " ";
        }
        for (let j = 1; j <= 2 * i - 1; j++) {
            output += character;
        }
        output += "\n";
        space--;
    }

    space = 1;

    for (let i = 1; i <= height - 1; i++) {
        for (let j = 1; j <= space; j++) {
            output += " ";
        }
        space++;
        for (let k = 1; k <= 2 * (height - i) - 1; k++) {
            output += character;
        }
        output += "\n";
    }
    return output;
}