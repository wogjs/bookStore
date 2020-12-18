let DateSet = () => {
    let date = document.getElementsByName("date");

    Array.from(date).forEach((item,index) => {
        var strArray = item.innerHTML.substr(0,10).split('-');
        item.innerHTML = strArray[0]+"년"+strArray[1]+"월"+strArray[2]+"일"
    })
    BookSet()
}

let BookSet = () => {
    let book = document.getElementsByName("book");

    Array.from(book).forEach((item,index) => {
        var strArray = item.innerHTML.split(',');
        if(strArray.length > 1) {
            var amount = strArray.length - 1;
            item.innerHTML = strArray[0]+" 외 "+amount+"권";
        } 
    })
    MoneySet()
}

let MoneySet = () => {
    let money = document.getElementsByName("money");
    Array.from(money).forEach((item,index) => {
        item.innerHTML = item.innerHTML.replace(/\B(?=(\d{3})+(?!\d))/g, ",")+"원";
    })
}