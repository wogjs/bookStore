window.onload = () => {
    let oa = document.getElementsByName("amount")
    var j = 0;
    oa.forEach((item, index) => {
        j = index*2;
        item.value = searchParam("oa")[j];
    })
    totalPriceSet()
}

let totalPriceSet = () => {
    let total = document.getElementsByClassName("total");
    let totalPrice = document.getElementById("totalPri");
    let totalSum = 0;
    let amount = document.getElementsByName("amount");
    let table = document.getElementById("books");
    let tbody = table.children[1];
    Array.from(tbody.children).forEach((item, index) => {
        let price = item.children[2].innerHTML*1;
        let count = amount[index].value*1;
        let sum = price*count;
        totalSum = totalSum + sum;
        total[index].innerHTML = '<span name="sum" value="'+sum+'">'+sum+'</span>';
    })
    totalPrice.innerHTML = totalSum;
}

let count_change = () => {
    totalPriceSet()
    return false;
}


function searchParam(key) {
    return new URLSearchParams(location.search).get(key);
}