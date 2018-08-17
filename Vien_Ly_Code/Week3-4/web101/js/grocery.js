$("#add").on("click", function() {
    let text = $("#newItem").val();
    let item = document.createElement('li');
    $(item).addClass("cartItem");
    item.innerText = text;
    $("#cart").append(item);
    $("#newItem").val("");
})

$("#cart").on("click", "li", function() {
    $("#purchased").append(this);
})
