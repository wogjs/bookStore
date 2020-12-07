var main = {
    init : function() {
        var _this = this;

        $('#btn-buy').on('click', function() {
            _this.buy();
        });
    },

    buy : function() {
        var data = {
            addrCode: $("#addr option:selected").val(),
            cardNum: $("#card option:selected").val(),
            orderSum : document.getElementById("totalPri").innerHTML*1
        };

        if(data.addrCode === "0" || data.cardNum === "0"){
            alert("배송지와 카드를 선택하였는지 확인해주세요");
            return false
        } else {
            $.ajax({
                type: 'POST',
                url: '/orders/orderPay?isbn='+searchParam('isbn')+'&oa='+searchParam('oa'),
                dataType: 'JSON',
                contentType:'application/json; charset=UTF-8',
                data: JSON.stringify(data)
            }).done(function() {
                alert("도서구매 완료");
                window.location.href = '/';
            }).fail(function(error) {
                console.log(error);
                alert(JSON.stringify(error));
            });
        }
    }

};

function searchParam (key) {
    return new URLSearchParams(location.search).get(key);
}

main.init();