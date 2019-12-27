
function fetchCompanies() {
    return fetch(
        `${API_URL}/companies`,
        {
            method: 'GET',
            headers: {
                'Authorization': `Bearer ${getToken()}` //muidu ei lasta välisuksest sisse
            }
        }
    )
    .then(checkResponse)
    .then(companies => companies.json());
}

function fetchChildren() {
    return fetch(
        `${API_URL}/children`,
        {
            method: 'GET',
            headers: {
                'Authorization': `Bearer ${getToken()}` //muidu ei lasta välisuksest sisse
            }
        }
    )
    .then(checkResponse)
    .then(children => children.json());
}

function fetchCompany(id) {
    return fetch(
        `${API_URL}/companies/${id}`,
        {
            method: 'GET',
            headers: {
                'Authorization': `Bearer ${getToken()}`
            }
        }
    )
    .then(checkResponse)
    .then(company => company.json());
}

function postMenu(childMenu) {
    return fetch(
        `${API_URL}/nutritiondata/register`,
        {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${getToken()}`
            },
            body: JSON.stringify(childMenu)
        })
    //.then(checkResponse)
    //.then(menu => menu.json());
}

function fetchMenu(id) {
    return fetch(
        `${API_URL}/nutritiondata/menu/${id}`,
        {
            method: 'GET',
            headers: {
                'Authorization': `Bearer ${getToken()}`
            }
        }
    )
    .then(checkResponse)
    .then(menu => menu.json());
}

function fetchChild(id) {
    return fetch(
        `${API_URL}/children/${id}`,
        {
            method: 'GET',
            headers: {
                'Authorization': `Bearer ${getToken()}`
            }
        }
    )
    .then(checkResponse)
    .then(child => child.json());
}

function uploadFile(file) {
    let formData = new FormData();
    formData.append("file", file);

    return fetch(
            `${API_URL}/files/upload`, 
            {
                method: 'POST',
                headers: {
                    'Authorization': `Bearer ${getToken()}`
                },
                body: formData
            }
    )
    .then(checkResponse).then(response => response.json());
}

function postCompany(company) {
    return fetch(
        `${API_URL}/companies`, 
        {
            method: 'POST', 
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${getToken()}`
            },
            body: JSON.stringify(company)
        }
    )
    .then(checkResponse);
}

function postChild(child) {
    return fetch(
        `${API_URL}/children/register`, 
        {
            method: 'POST', 
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${getToken()}`
            },
            body: JSON.stringify(child)
        }
    );
    // .then(checkResponse);
}

function postUser(user) {
    return fetch(
        `${API_URL}/users/register`, 
        {
            method: 'POST', 
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(user)
        }
    );
    // .then(checkResponse);
}



function deleteCompany(id) {
    return fetch(
        `${API_URL}/companies/${id}`,
        {
            method: 'DELETE',
            headers: {
                'Authorization': `Bearer ${getToken()}`
            }
        }
    )
    .then(checkResponse);
}

function deleteChild(id) {
    return fetch(
        `${API_URL}/children/${id}`,
        {
            method: 'DELETE',
            headers: {
                'Authorization': `Bearer ${getToken()}`
            }
        }
    )
    .then(checkResponse);
}

function login(credentials) {
    return fetch(
        `${API_URL}/users/login`,
        {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(credentials)
        }
    )
    .then(checkResponse)
    .then(session => session.json());
}

/*function checkResponse(response) {
    if (!response.ok) {
        clearAuthentication();
        showLoginContainer();
        closeCompanyModal();
        generateTopMenu();
        throw new Error(response.status);
    }
    showMainContainer();
    return response;
}*/

function checkResponse(response) {
    if (!response.ok) {
        clearAuthentication();
        showLoginContainer();
        closeChildModal();
        generateTopMenu();
        throw new Error(response.status);
    }
    showMainContainer();
    return response;
}
