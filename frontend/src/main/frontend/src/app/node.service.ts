import { Http } from '@angular/http';
import { Injectable } from '@angular/core';
import 'rxjs/add/operator/map';
import {Observable} from 'rxjs/Rx';

@Injectable()
export class NodeService {
    baseUrl = "http://localhost:8080/api/";

    constructor(private http: Http) {

    }

    getNodes() {
        return this.http.get(this.baseUrl + "getAllNodes").map(res => res.json());
    }

    getTopNodes() {
        return this.http.get(this.baseUrl + "getTopNodes").map(res => res.json());
    }

    addNode(name, parent) {
        var data = "name=" + name;
        if (parent) {
            data = data + "&parentId=" + parent;
        }
        var url = this.baseUrl + "createNode?";
        var request = url + data;
       return this.http.post(request, null);
    }

}