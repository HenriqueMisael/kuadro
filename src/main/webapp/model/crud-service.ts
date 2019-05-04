import axios, { AxiosPromise } from "axios";

const API_URL = `http://localhost:8080/api/`;

export default class CrudService<T> {
    crudName: string;

    constructor(crudName: string) {
        this.crudName = crudName;
    }

    public findAll(): AxiosPromise<T[]> {
        return axios.get(`${API_URL}${this.crudName}`);
    }

    public find(id: number): AxiosPromise<T> {
        return axios.get(`${API_URL}${this.crudName}/${id}`);
    }

    public update(id: number, entity: T): AxiosPromise<T> {
        return axios.put(`${API_URL}${this.crudName}/${id}`, entity);
    }

    public create(entity: T): AxiosPromise<T> {
        return axios.post(`${API_URL}${this.crudName}`, entity);
    }

    public delete(id: number): AxiosPromise<T> {
        return axios.delete(`${API_URL}${this.crudName}/${id}`);
    }
}