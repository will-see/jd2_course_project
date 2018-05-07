$(document).ready(function () {
    $('#getBook').click(function () {
        getBook();
    });
    $('.reduceProductBtn').click(function () {
        reduceProduct($(this));
    });
    $('#doAjax').click(function () {
        doAjax();
    });

});

function doAjax() {

    var inputText = $("#input_str").val();

    $.ajax({
        url : 'getCharNum',
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        data : ({
            text: inputText
        }),
        success: function (data) {

            var result = '"'+data.text+'", '+data.count+' characters';
            $("#result_text").text(result);
        }
    });
}
function getBook(element) {
    var bookId = $(element).attr('id');
    var json = JSON.stringify(bookId);
    console.log(json);
    $.ajax({
        type: 'get',
        url: contextUrl + '/books/getBook' + bookId
    }).done(function (data) {
        $('#count'+bookId).text(data);
    }).fail(function (data) {
        if (console && console.log) {
            console.log("Error data:", data);
        }
    });
}
// function getBook(element) {
//     var bookId = $(element).attr('id');
//     var json = JSON.stringify(bookId);
//     console.log(json);
//     $.ajax({
//         type: 'get',
//         url: contextUrl + '/library/books/getBook' + bookId
//     }).done(function (data) {
//         $('#count'+bookId).text(data);
//     }).fail(function (data) {
//         if (console && console.log) {
//             console.log("Error data:", data);
//         }
//     });
// }

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
