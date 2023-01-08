import axios from 'axios';

const request = axios.create({
    baseURL: 'http://localhost:8080',
    headers: {
        'content-type': 'application/json',
    },
});

export const get = async (url) => {
    const response = await request.get(url);
    return response.data;
};

export const login = async (email, password) => {
    const response = await request.post('/login', {
        email: email,
        password: password,
    });

    return response;
};

export default request;
