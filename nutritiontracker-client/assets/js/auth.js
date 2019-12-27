
function clearAuthentication() {
    localStorage.removeItem(AUTH_TOKEN);
    localStorage.removeItem(AUTH_USERNAME);
}

function storeAuthentication(session) {
    localStorage.setItem(AUTH_TOKEN, session.token);
    localStorage.setItem(AUTH_USERNAME, session.username);
}

function getUsername() {
    return localStorage.getItem(AUTH_USERNAME);
}

function getToken() {
    return localStorage.getItem(AUTH_TOKEN);
}
