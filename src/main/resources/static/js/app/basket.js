let totalPriceSet = () => {
    let total = document.getElementById("total")
    let totalprice = document.getElementById("total");
    let table = document.getElementById("books");
    let tbody = table.children[1];
    Array.from(tbody.children).forEach((item, index) => {
        let price = item.children[2].innerHTML*1;
        let count = item.children[3].innerHTML*1;
        let sum = price*count;
        total.innerHTML = '<div>최종 결제금액 : <span id="sum" value="'+sum+'">'+sum+'</span></div>';
    })
}