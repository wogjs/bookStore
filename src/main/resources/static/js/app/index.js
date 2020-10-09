var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-login').on('click', function() {
            _this.login();
        })

//        $('#btn-update').on('click', function () {
//            _this.update();
//        });
//
//        $('#btn-delete').on('click', function () {
//            _this.delete();
//        });
    },
    save : function () {
        var data = {
            id: $('#id').val(),
            pw: $('#pw').val(),
            name: $('#name').val(),
            sex: $('#sex').val(),
            num: $('#num').val(),
            mail: $('#mail').val(),
            nic_name: $('#nic_name').val()

        };

        $.ajax({
            type: 'POST',
            url: '/users/userJoin',
            dataType: 'text',
            contentType:'application/json; charset=UTF-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('회원가입 되었습니다..');
            window.location.href = '/';
        }).fail(function (error) {
            console.log(error)
            alert(JSON.stringify(error));
        });
    },

    login : function () {
        var data = {
            id: $('#id').val(),
            pw: $('#pw').val()
        };

        $.ajax({
            type: 'POST',
            url: '/users/signIn',
            dataType: 'text',
            contentType:'application/json; charset=UTF-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('로그인이 되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            console.log(error)
            alert(JSON.stringify(error));
        });
    }
//    update : function () {
//        var data = {
//            title: $('#title').val(),
//            content: $('#content').val()
//        };
//
//        var id = $('#id').val();
//
//        $.ajax({
//            type: 'PUT',
//            url: '/api/v1/posts/'+id,
//            dataType: 'json',
//            contentType:'application/json; charset=utf-8',
//            data: JSON.stringify(data)
//        }).done(function() {
//            alert('글이 수정되었습니다.');
//            window.location.href = '/';
//        }).fail(function (error) {
//            alert(JSON.stringify(error));
//        });
//    },
//    delete : function () {
//        var id = $('#id').val();
//
//        $.ajax({
//            type: 'DELETE',
//            url: '/api/v1/posts/'+id,
//            dataType: 'json',
//            contentType:'application/json; charset=utf-8'
//        }).done(function() {
//            alert('글이 삭제되었습니다.');
//            window.location.href = '/';
//        }).fail(function (error) {
//            alert(JSON.stringify(error));
//        });
//    }
};
main.init();