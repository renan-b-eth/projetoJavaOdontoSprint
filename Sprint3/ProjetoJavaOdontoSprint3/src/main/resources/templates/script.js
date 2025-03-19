const colors = ["#FF5733", "#33FF57", "#3357FF", "#F3FF33", "#FF33A4"];
let index = 0;

function changeBackgroundColor() {
    document.body.style.backgroundColor = colors[index];
    index = (index + 1) % colors.length;
}

setInterval(changeBackgroundColor, 2000); // Muda a cor a cada 2 segundos