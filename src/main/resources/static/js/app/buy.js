var main = {
  init: function () {
    var _this = this;

    $('#btn-buy').on('click', function () {
      _this.buy();
    });

    $('#btn-basket').on('click', function () {
      _this.basket();
    });
  },

  buy: function () {
    var data = {
      isbn: $('#isbn').text(),
      orderSum: $('#amount').val(),
    };

    $.ajax({
      type: 'POST',
      url: '/orders/' + data.isbn,
      dataType: 'JSON',
      contentType: 'application/json; charset=UTF-8',
      data: JSON.stringify(data),
    })
      .done(function () {
        alert('추가되었습니다.');
        window.location.href = '/orders/' + isbn;
      })
      .fail(function (error) {
        console.log(error);
        alert(JSON.stringify(error));
      });
  },
};
main.init();
