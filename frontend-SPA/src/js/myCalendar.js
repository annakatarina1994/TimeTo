const renderMyHeader = () => {
    const headerElement = document.createElement("header");
    headerElement.classList.add("header");
    headerElement.innerText = "My Calendar";
    return headerElement;
}

const renderMonth = ()=> {
    const monthHeader = document.createElement("div");
    monthHeader.classList.add("monthHeader")
    const monthElement = document.createElement("span");
    monthElement.classList.add("currentMonth");
    monthElement.innerText = "Month";
    monthHeader.appendChild(monthElement);
    return monthElement;
}

const clearBackground = () => {
    const body = document.querySelector('.home');
    body.classList.remove('.home');
}
const clearView = () => {
    const body = document.querySelector("body")
    while (body.firstChild) {
        body.removeChild(body.firstChild);
    }
    
}
const renderBackground = () => {
    const backgroundElement = document.querySelector(".my_background")
    document.body.style.background = "blue";
}
const displayMyPage = () => {
    clearView();
    const container = document.querySelector(".container");
    // clearBackground();
    // renderBackground();
    container.appendChild(renderMyHeader());
    container.append(renderMonth());
}

export {
    displayMyPage
}