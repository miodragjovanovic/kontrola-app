import { Component } from '@angular/core';
import {NodeService} from './node.service'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers:  [NodeService]
})
export class AppComponent {
  nodes = [];

  constructor(private nodeService: NodeService) {
    this.getNodes();       
  }

  getNodes() {
     this.nodeService.getNodes().subscribe(nodes => {
      this.nodes = nodes;
    });
  }


  public addNode(name, parent) {
          this.nodeService.addNode(name, parent).subscribe(res => {
     this.getNodes(); 
    }); ;     
      }
}
