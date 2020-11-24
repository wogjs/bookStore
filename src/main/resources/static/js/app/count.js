$(function(){
    $(document).ready(function(){
        var price = $('#bkprice').text();
        var amount = $('#amount').val();
        var total = price * amount;

        console.log("들어왔는가");

        var span = document.createElement("span");
        
        span.setAttribute("id","sp_price");
        span.innerHtml = total;
        $('#total').prepend(span);
    }),
    $("#downB").click(function(){
        var amount = $('#amount').val();

        amount = amount -1;
        
        if(amount < 1) {
            alert("1권 밑으로 설정할 수 없습니다.");
            amount++;
        }
        $("#amount").val(amount);
        priceUpdate();
    }),
    $("#upB").click(function() {
        var amount = $('#amount').val();

        amount++;
        $("#amount").val(amount);
        priceUpdate();
    });

    function priceUpdate(){
        var price = $('#bkprice').text();
        var amount = $('#amount').val();
        var total = price * amount;
        $("span").remove("#value");
        $('#sp_price').text(total);
    }    
})