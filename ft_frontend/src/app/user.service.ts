import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
@Injectable(
    {
        providedIn: 'root'
    }
)
export class UserService{
    
    private apiServerUrl = 'http://localhost:8080';
    constructor(private http: HttpClient) { }
    async submitLogin(username: string, password: string)
    {
        const data = {username,password};
        return this.http.post<any>(`${this.apiServerUrl}/api/User/coord`,data);    
    }
}