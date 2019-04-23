import { Component, OnInit } from '@angular/core';
import { BearService } from '../../services/bear.service';
import { Bear } from '../../models/bear.model';
import { Cave } from '../../models/cave.model';
import { BearType } from '../../models/bear-type.model';
import { BearList } from '../../models/bear-list.model';

@Component({
  selector: 'app-http',
  templateUrl: './http.component.html',
  styleUrls: ['./http.component.css']
})
export class HttpComponent implements OnInit {

  title = 'HTTP';
  documentation = 'https://angular.io/guide/http';

  public bears: Bear[];
  public selectedBearId: number;
  public bear: Bear; // = new Bear(3, "Fred", new Cave(5, "Camp Awesome", 7), new BearType(8, "Grizzly"), 400, new Date());

  // Inject service
  constructor(private bearService: BearService) { }

  getBearInformation(): void {
    this.bearService.fetchBearInformation(this.selectedBearId)
      .subscribe(
        bear => this.bear = bear,
        error => console.log(`Error: ${error} `)
      );
  }

  getBears(): void {
    this.bearService.fetchAllBears()
      .subscribe(
        (bearList: any) => { this.bears = bearList; console.log(this.bears); },
        error => { console.log(error); }
      );
    console.log('populated bears');
  }
  // if we want to make the call when component is created
  ngOnInit() {
    // this.getBearInformation();
    // with the current setup the component is created with no preselected bear
  }
}
