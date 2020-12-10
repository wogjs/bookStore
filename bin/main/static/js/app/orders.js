var main = {
    init: function () {
        var _this = this;

        $('#btn-buy').on('click', function () {
            _this.buy();
        });

        $('#btn-nonbuy').on('click', function () {
            _this.nonbuy();
        })

        $('#btn-basket').on('click', function () {
            _this.basket();
        });

        $('#btn-order').on('click', function () {
            _this.order();
        });
    },

    buy: function () {
        var data = {
            isbn: $('#isbn').text(),
            orderAmount: $('#amount').val(),
        };

        window.location.href = '/orders/Pay?isbn=' + data.isbn + '&oa=' + data.orderAmount;
    },

    nonbuy: function () {
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

    order: function () {
        var data = {
            addrCode: $("#addr option:selected").val(),
            cardNum: $("#card option:selected").val(),
            orderSum: document.getElementById("totalPri").innerHTML * 1
        };

        let orderUrl = window.location.pathname;

        if (data.addrCode === "0" || data.cardNum === "0") {
            alert("배송지와 카드를 선택하였는지 확인해주세요");
            return false
        } else {
            $.ajax({
                type: 'POST',
                url: orderUrl + '?isbn=' + searchParam('isbn') + '&oa=' + searchParam('oa'),
                dataType: 'JSON',
                contentType: 'application/json; charset=UTF-8',
                data: JSON.stringify(data)
            }).done(function () {
                alert("도서구매 완료");
                window.location.href = '/';
            }).fail(function (error) {
                console.log(error);
                alert(JSON.stringify(error));
            });
        }
    }

};

function searchParam(key) {
    return new URLSearchParams(location.search).get(key);
}

main.init();