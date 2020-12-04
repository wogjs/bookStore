var main = {
    init : function() {
        var _this = this;

        $('#btn-buy').on('click', function() {
            _this.buy();
        });
    },

    buy : function() {
        var data = {
            addr: $("#addr option:selected").val(),
            card: $("#card option:selected").val()
        };
        console.log(data.addr);
        console.log(data.card);
        // $.ajax({
        //     type: 'POST',
        //     url: '/books/bookInsert',
        //     dataType: 'JSON',
        //     contentType:'application/json; charset=UTF-8',
        //     data: JSON.stringify(data)
        // }).done(function() {
        //     alert("도서등록 완료");
            
        // }).fail(function(error) {
        //     console.log(error);
        //     alert(JSON.stringify(error));
        // });
    }

};
main.init();