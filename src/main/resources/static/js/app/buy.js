var main = {
  init: function () {
    var _this = this;

    $('#btn-buy').on('click', function () {
      _this.buy();
    });

    $('#btn-nonbuy').on('click',function() {
      _this.nonbuy();
    })

    $('#btn-basket').on('click', function () {
      _this.basket();
    });
  },

  buy: function () {
    var data = {
      isbn: $('#isbn').text(),
      orderSum: $('#amount').val(),
    };

    window.location.href = '/orders?isbn=' + data.isbn + '&os=' + data.orderSum;
  },

  nonbuy: function(){
    alert("로그인이 필요합니다.");
    window.location.href = '/users/login'
  },

  basket: function () {
    var data = {
      isbn: $('#isbn').text(),
      basAmount: $('#amount').val(),
    };

    $.ajax({
      type: 'POST',
      url: '/basket/' + data.isbn,
      dataType: 'TEXT',
      contentType: 'application/json; charset=UTF-8',
      data: JSON.stringify(data),
    })
      .done(function () {
        alert('추가되었습니다.');
        window.location.href = '/';
      })
      .fail(function (error) {
        console.log(error);
        alert(JSON.stringify(error));
      });
  },
};
main.init();
