var main = {
    init : function() {
        var _this = this;

        $('#btn-save').on('click', function() {
            _this.save();
        });
    },

    save : function() {
        var data = {
            isbn: $('#isbn').val(),
            bookName: $('#bookName').val(),
            bookAut: $('#bookAut').val(),
            bookTrans: $('#bookTrans').val(),
            bookDate: $('#bookDate').val(),
            bookCov: $('#bookCov').val(),
            bookPri: $('#bookPri').val(),
            bookGen: $('#bookGen').val(),
            bookDet: $('#bookDet').val()
        };

        $.ajax({
            type: 'POST',
            url: '/books/bookInsert',
            dataType: 'JSON',
            contentType:'application/json; charset=UTF-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert("도서등록 완료");
            window.location.href = '/';
        }).fail(function(error) {
            console.log(error);
            alert(JSON.stringify(error));
        });
    }

};
main.init();