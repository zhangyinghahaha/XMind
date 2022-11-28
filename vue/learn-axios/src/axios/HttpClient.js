import axios from "axios";

class HttpClient {
    constructor(baseURL, timeout = 1000) {
        this.instance = axios.create({ baseURL, timeout });
    }

    request(config) {
        return new Promise((resolve, reject) => {
            this.instance
                .request(config)
                .then((response) => {
                    resolve(response.data);
                })
                .catch((err) => {
                    console.log('request err:', err);
                    reject(err);
                });
        });
    }

    get(url, config) {
        return this.request({ url: url, method: "get", ...config });
    }
}

const httpClient = new HttpClient();
export default httpClient;
