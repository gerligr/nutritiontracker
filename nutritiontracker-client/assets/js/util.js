
// Validation functions

function validateCompanyModal(company) {
    if (isEmpty(company.name)) {
        showError("Nimi on kohustuslik!")
        return false;
    }
    if (!isEmpty(company.employees) && !isInteger(company.employees)) {
        showError("Töötajate arv peab olema täisarv!");
        return false;
    }
    if (!isEmpty(company.revenue) && !isDecimal(company.revenue)) {
        showError("Müügitulu peab olema number!");
        return false;
    }
    if (!isEmpty(company.netIncome) && !isDecimal(company.netIncome)) {
        showError("Netotulu peab olema number!");
        return false;
    }
    if (!isEmpty(company.securities) && !isInteger(company.securities)) {
        showError("Aktsiate arv peab olema täisarv!");
        return false;
    }
    if (!isEmpty(company.securityPrice) && !isDecimal(company.securityPrice)) {
        showError("Aktsiahind peab olema number!");
        return false;
    }
    if (!isEmpty(company.dividends) && !isDecimal(company.dividends)) {
        showError("Dididend peab olema number!");
        return false;
    }
    return true;
}
function validateUserModal(user) {
    if (isEmpty(user.name)) {
        showUserError("Nimi on kohustuslik!");
        return false;
    }
    if (isEmpty(user.username)) {
        showUserError("Kasutajanimi on kohustuslik!");
        return false;
    }
    if (isEmpty(user.password)) {
        showUserError("Salasõna on kohustuslik!");
        return false;
    }
    if (isEmpty(user.email)) {
        showUserError("E-mail on kohustuslik!");
        return false;
    }
    return true;
}

function validateChildModal(child) {
    if (isEmpty(child.name)) {
        showChildError("Nimi on kohustuslik!");
        return false;
    }
    if (isEmpty(child.age)) {
        showChildError("Vanus on kohustuslik!");
        return false;
    }
    if (isEmpty(child.gender)) {
        showChildError("Sugu on kohustuslik!");
        return false;
    }
    if (isEmpty(child.physicalActivity)) {
        showChildError("Aktiivsus on kohustuslik!");
        return false;
    }
    return true;
}

function validateMenuModal(menu) {
    if (isEmpty(menu.breakfast)) {
        showMenuError("Palun vali hommikusöök!");
        return false;
    }
    if (isEmpty(menu.breakfastAmount)) {
        showMenuError("Palun määra hommikusöögi kogus!");
        return false;
    }
    if (isEmpty(menu.lunch)) {
        showMenuError("Palun vali lõunasöök!");
        return false;
    }
    if (isEmpty(menu.lunchAmount)) {
        showMenuError("Palun määra lõunasöögi kogus!");
        return false;
    }
    if (isEmpty(menu.dinner)) {
        showMenuError("Palun vali õhtusöök!");
        return false;
    }
    if (isEmpty(menu.dinnerAmount)) {
        showMenuError("Palun määra õhtusöögi kogus!!");
        return false;
    }
    return true;
}

function validateCredentials(credentials) {
    return !isEmpty(credentials.username) && !isEmpty(credentials.password);
}

function isInteger(text) {
    if (text == null) {
        return false;
    }
    let regex = /^[\-]?\d+$/;
    return regex.test(text);
}

function isDecimal(text) {
    if (text == null) {
        return false;
    }
    let regex = /^[\-]?\d+(\.\d+)?$/;
    return regex.test(text);
}

function isEmpty(text) {
    return (!text || 0 === text.length);
}

// DOM retrieval functions

function getFileInput() {
    return document.getElementById("file");
}

function getMenuInput() {

}

function getCompanyFromModal() {
    return {
        "id": document.getElementById("id").value,
        "name": document.getElementById("name").value,
        "logo": document.getElementById("logo").value,
        "established": document.getElementById("established").value,
        "employees": document.getElementById("employees").value,
        "revenue": document.getElementById("revenue").value,
        "netIncome": document.getElementById("netIncome").value,
        "securities": document.getElementById("securities").value,
        "securityPrice": document.getElementById("securityPrice").value,
        "dividends": document.getElementById("dividends").value
    };
}

function getUserFromModal() {
    return {
        "id": document.getElementById("id").value,
        "name": document.getElementById("registrationName").value,
        "username": document.getElementById("registrationUsername").value,
        "password": document.getElementById("registrationPassword").value,
        "email": document.getElementById("email").value
    };
}

function getChildFromModal() {
    return {
        "id": document.getElementById("childId").value,
        "name": document.getElementById("childName").value,
        "photo": document.getElementById("photo").value,
        "age": document.getElementById("age").value,
        "gender": document.getElementById("gender").value,
        "physicalActivity": document.getElementById("physicalActivity").value

    };
}

function getMenuFromModal() {
    return {
        "id": document.getElementById("menuId").value,
        "personId": document.getElementById("childId").value,
        "breakfast": document.getElementById("breakfast").value,
        "breakfastAmount": document.getElementById("breakfastAmount").value,
        "lunchsnack": document.getElementById("lunchsnack").value,
        "lunchsnackAmount": document.getElementById("lunchsnackAmount").value,
        "lunch": document.getElementById("lunch").value,
        "lunchAmount": document.getElementById("lunchAmount").value,
        "dinnersnack": document.getElementById("dinnersnack").value,
        "dinnersnackAmount": document.getElementById("dinnersnackAmount").value,
        "dinner": document.getElementById("dinner").value,
        "dinnerAmount": document.getElementById("dinnerAmount").value
    };
}

function getCredentialsFromLoginContainer() {
    return {
        username: document.getElementById("username").value,
        password: document.getElementById("password").value
    };
}

// Financial functions

function formatNumber(num) {
    if (!isDecimal(num)) {
        return 0;
    }
    num = Math.round(num * 100) / 100;
    return num.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1,')
}

// Chart Functions

function generateRandomColor() {
    let r = Math.floor(Math.random() * 255);
    let g = Math.floor(Math.random() * 255);
    let b = Math.floor(Math.random() * 255);
    return `rgb(${r},${g},${b})`;
}

function composeChartDataset(companies) {
    if (companies != null && companies.length > 0) {
        let data = companies.map(company => Math.round(company.marketCapitalization));
        let backgroundColors = companies.map(generateRandomColor);
        return [{
            data: data,
            backgroundColor: backgroundColors,
        }];
    }
    return [];
}

function composeChartLabels(companies) {
    return companies != null && companies.length > 0 ? companies.map(company => company.name) : [];
}

function composeChartData(companies) {
    return {
        datasets: composeChartDataset(companies),
        labels: composeChartLabels(companies)
    };
}

function composeNutritionSuggestion(calculation, nutrition) {
    if (calculation != null && nutrition != null) {

        let totalEnergy = calculation.totalEnergy;
        let suggestedEnergy = nutrition.energy;
        let energyFromWhole = totalEnergy * 100 / suggestedEnergy;
        let energyFromWholePct = parseInt((totalEnergy * 100) / suggestedEnergy);

        if (energyFromWhole > 100) {
            energyFromWhole = 1;
        } else if (energyFromWhole < 100) {
            energyFromWhole = -1;
        } else {
            energyFromWhole = 0;
        }

        let totalProteins = calculation.totalProteins;
        let suggestedProteinsMin = nutrition.proteinMin;
        let suggestedProteinsMax = nutrition.proteinMax;
        let proteinFromWhole = 0;

        if (totalProteins >= suggestedProteinsMin && totalProteins <= suggestedProteinsMax) {
            proteinFromWhole = 0; //"Valgud jäävad soovituslikku vahemikku"
        } else if (totalProteins < suggestedProteinsMin) {
            proteinFromWhole = -1; //"Valgud jäävad alla soovistuslikku vahemikku"
        } else if (totalProteins > suggestedProteinsMax) {
            proteinFromWhole = 1; //"Valgud ületavad soovistuslikku vahemikku"
        }


        let fatFromWhole = "";
        if (calculation.totalFats >= nutrition.fatMin && calculation.totalFats <= nutrition.fatMax) {
            fatFromWhole = 0; //"Rasvad jäävad soovituslikku vahemikku"
        } else if (calculation.totalFats < nutrition.fatMin) {
            fatFromWhole = -1; //"Rasvad jäävad alla soovistuslikku vahemikku"
        } else if (calculation.totalFats > nutrition.fatMax) {
            fatFromWhole = 1; //"Rasvad ületavad soovistuslikku vahemikku"
        }

        let carbFromWhole = "";
        if (calculation.totalCarbs >= nutrition.carbMin && calculation.totalCarbs <= nutrition.carbMax) {
            carbFromWhole = 0; //"Süsivesikud jäävad soovituslikku vahemikku"
        } else if (calculation.totalCarbs < nutrition.carbMin) {
            carbFromWhole = -1; //"Süsivesikud jäävad alla soovistuslikku vahemikku"
        } else if (calculation.totalCarbs > nutrition.carbMax) {
            carbFromWhole = 1; //"Süsivesikud ületavad soovistuslikku vahemikku"
        }

        let energyFromWholeText = "";
        if (energyFromWhole === 0) {
            energyFromWholeText = "Normis";

        } else if (energyFromWhole === -1) {
            energyFromWholeText = "Alla normi";

        } else if (energyFromWhole === 1) {
            energyFromWholeText = "Üle normi";
        }

        let proteinFromWholeText = "";
        if (proteinFromWhole === 0) {
            proteinFromWholeText = "Normis";

        } else if (proteinFromWhole === -1) {
            proteinFromWholeText = "Alla normi";

        } else if (proteinFromWhole === 1) {
            proteinFromWholeText = "Üle normi";
        }

        let fatFromWholeText = "";
        if (fatFromWhole === 0) {
            fatFromWholeText = "Normis";

        } else if (fatFromWhole === -1) {
            fatFromWholeText = "Alla normi";

        } else if (fatFromWhole === 1) {
            fatFromWholeText = "Üle normi";
        }

        let carbFromWholeText = "";
        if (carbFromWhole === 0) {
            carbFromWholeText = "Normis";

        } else if (carbFromWhole === -1) {
            carbFromWholeText = "Alla normi";

        } else if (carbFromWhole === 1) {
            carbFromWholeText = "Üle normi";
        }


        let proteinFromWholePct = 0;

        if (totalProteins > suggestedProteinsMax) {
            proteinFromWholePct = parseInt((totalProteins * 100) / suggestedProteinsMax);
        } else if (totalProteins < suggestedProteinsMin) {
            proteinFromWholePct = parseInt((totalProteins * 100) / suggestedProteinsMin);
        } else if (totalProteins <= suggestedProteinsMax && totalProteins >= suggestedProteinsMin) {
            proteinFromWholePct = 100;
        }

        let totalFats = calculation.totalFats;
        let suggestedFatsMin = nutrition.fatMin;
        let suggestedFatsMax = nutrition.fatMax;
        let fatFromWholePct = 0;

        if (totalFats > suggestedFatsMax) {
            fatFromWholePct = parseInt((totalFats * 100) / suggestedFatsMax);
        } else if (totalFats < suggestedFatsMin) {
            fatFromWholePct = parseInt((totalFats * 100) / suggestedFatsMin);
        } else if (totalFats <= suggestedFatsMax && totalFats >= suggestedFatsMin) {
            fatFromWholePct = 100;
        }

        let totalCarbs = calculation.totalCarbs;
        let suggestedCarbsMin = nutrition.carbMin;
        let suggestedCarbsMax = nutrition.carbMax;
        let carbFromWholePct = 0;

        if (totalCarbs > suggestedCarbsMax) {
            carbFromWholePct = parseInt((totalCarbs * 100) / suggestedCarbsMax);
        } else if (totalCarbs < suggestedCarbsMin) {
            carbFromWholePct = parseInt((totalCarbs * 100) / suggestedCarbsMin);
        } else if (totalCarbs <= suggestedCarbsMax && totalCarbs >= suggestedCarbsMin) {
            carbFromWholePct = 100;
        }

        return {
            energyFromWhole: energyFromWhole,
            energyFromWholeText: energyFromWholeText,
            proteinFromWhole: proteinFromWhole,
            proteinFromWholeText: proteinFromWholeText,
            fatFromWhole: fatFromWhole,
            fatFromWholeText: fatFromWholeText,
            carbFromWhole: carbFromWhole,
            carbFromWholeText: carbFromWholeText,
            energyFromWholePct: energyFromWholePct,
            proteinFromWholePct: proteinFromWholePct,
            fatFromWholePct: fatFromWholePct,
            carbFromWholePct: carbFromWholePct
        };

    }

    return {
        energyFromWhole: -1000,
        energyFromWholeText: "info puudub",
        proteinFromWhole: -100,
        proteinFromWholeText: "info puudub",
        fatFromWhole: -100,
        fatFromWholeText: "info puudub",
        carbFromWhole: -100,
        carbFromWholeText: "info puudub",
        energyFromWholePct: -100,
        proteinFromWholePct: -100,
        fatFromWholePct: -100,
        carbFromWholePct: -100
    };


}

const transitionDuration = 900;

function initGraphics() {
    const displays = document.querySelectorAll('.note-display');
    displays.forEach(display => {
        let note = parseFloat(display.dataset.note);
        let [int, dec] = display.dataset.note.split('.');
        [int, dec] = [Number(int), Number(dec)];

        // strokeTransition(display, note);

        increaseNumber(display, int, 'int');
        // increaseNumber(display, dec, 'dec');

    });
}

function strokeTransition(display, note) {
    let progress = display.querySelector('.circle__progress--fill');
    let radius = progress.r.baseVal.value;
    let circumference = 2 * Math.PI * radius;
    let offset = circumference * (10 - note) / 10;

    progress.style.setProperty('--initialStroke', circumference);
    progress.style.setProperty('--transitionDuration', `${transitionDuration}ms`);

    setTimeout(() => progress.style.strokeDashoffset = offset, 100);

    progress.style.setProperty('--initialStroke', circumference);
    progress.style.setProperty('--transitionDuration', `${transitionDuration}ms`);

    setTimeout(() => progress.style.strokeDashoffset = offset, 100);

}

function increaseNumber(display, number, className) {
    let element = display.querySelector(`.percent__${className}`),
        decPoint = className === 'int' ? ' ' : '',
        interval = transitionDuration / number,
        counter = 0;

    let increaseInterval = setInterval(() => {
        if (counter === number) { window.clearInterval(increaseInterval); }

        element.textContent = counter + decPoint;
        counter++;
    }, interval);
}


