$(document).ready(function () {
    $('.getBookBtn').click(function () {
        getBook($(this));
    });
    $('.reduceProductBtn').click(function () {
        reduceProduct($(this));
    });
});

function getBook(element) {
    var bookId = $(element).attr('id');
    var json = JSON.stringify(bookId);
    console.log(json);
    $.ajax({
        type: 'get',
        url: contextUrl + '/frontController?command=getBook&bookId=' + bookId
    }).done(function (data) {
        $('#count'+bookId).text(data);
    }).fail(function (data) {
        if (console && console.log) {
            console.log("Error data:", data);
        }
    });
}

function reduceProduct(element) {
    var bookId = $(element).attr('id');
    $.ajax({
        type: 'post',
        url: contextUrl + '/frontController',
        data:{command:'reduceProduct', id:productId}
    }).done(function (data) {
        $('#count'+bookId).text(data);
    }).fail(function (data) {
        if (console && console.log) {
            console.log("Error data:", data);
        }
    });
}
