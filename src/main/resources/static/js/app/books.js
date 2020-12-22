var main = {
    init : function() {
        var _this = this;

        $('#btn-save').on('click', function() {
            _this.save();
        });

        $('#btn-search').on('click', function () {
            _this.search();
        })
    },

    save : function() {
        var data = {
            isbn: $('#isbn').val(),
            bookName: $('#bookName').val(),
            bookAut: $('#bookAut').val(),
            bookTrans: $('#bookTrans').val(),
            bookDate: $('#bookDate').val(),
            bookHouse: $('#bookHouse').val(),
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
    },

    search : function() {
        var what = $("#searchWhat option:selected").val();

        console.log(what);

        var data = {
            searchWhat: what,
            searchKey: $('#searchKey').val()
        };
        
        if(what == "no") {
            alert("검색방법을 선택해주세요");
            return null;
        } else{
            window.location.href="/bookSearch?searchWhat="+data.searchWhat+"&searchKey="+data.searchKey;
        }

    }

};
main.init();