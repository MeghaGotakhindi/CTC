import { Component, OnInit } from '@angular/core';
import * as CanvasJS from '../state/canvasjs.min';

@Component({
  selector: 'app-state',
  templateUrl: './state.component.html',
  styleUrls: ['./state.component.scss']
})
export class StateComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    let chart = new CanvasJS.Chart("chartContainer1", {
      // animationEnabled: true,
      // exportEnabled: true,
      data: [{
        type: "line",
        dataPoints: [
          { y: 0.0, label: "11:45AM" },
          { y: 0.5, label: "11:50AM" }, 
          { y: 1.0, label: "11:55AM" }
        ]
      }]
    });

    let chart1 = new CanvasJS.Chart("chartContainer2", {
      // animationEnabled: true,
      // exportEnabled: true,
      data: [{
        type: "line",
        dataPoints: [
          { y: 0, label: "11:45AM" },
          { y: 100, label: "11:50AM" },
          { y: 200, label: "11:55AM" }
        ]
      }]
    });

    let chart2 = new CanvasJS.Chart("chartContainer3", {
      axisY: {
        minimum: 0,
        maximum: 100
      },
      // animationEnabled: true,
      // exportEnabled: true,
      data: [{
        type: "line",

        dataPoints: [
          { y: 0, label: "11:45AM" },    
          { y: 0, label: "11:50AM" }
        ]
      }]
    });

    chart.render();
    chart1.render();
    chart2.render();
  }

  //   chartData = {
  //     labels: ["S", "M", "T", "W", "T", "F", "S"],
  //     datasets: [{
  //       data: [589, 445, 483, 503, 689, 692, 634],
  //     },
  //     ]
  //   };

  // chLine = document.getElementById("chLine");
  // if (chLine) {
  //   new Chart(chLine, {
  //   type: 'line',
  //   data: this.chartData,
  //   options: {
  //     scales: {
  //       yAxes: [{
  //         ticks: {
  //           beginAtZero: false
  //         }
  //       }]
  //     },
  //     legend: {
  //       display: false
  //     }
  //   }
  //   });
  // }

  // public chartType: string = 'line';

  //   public chartDatasets: Array<any> = [
  //     { data: [65, 59, 80, 81, 56, 55, 40], label: 'My First dataset' },
  //     { data: [28, 48, 40, 19, 86, 27, 90], label: 'My Second dataset' }
  //   ];

  //   public chartLabels: Array<any> = ['January', 'February', 'March', 'April', 'May', 'June', 'July'];

  //   public chartColors: Array<any> = [
  //     {
  //       backgroundColor: 'rgba(105, 0, 132, .2)',
  //       borderColor: 'rgba(200, 99, 132, .7)',
  //       borderWidth: 2,
  //     },
  //     {
  //       backgroundColor: 'rgba(0, 137, 132, .2)',
  //       borderColor: 'rgba(0, 10, 130, .7)',
  //       borderWidth: 2,
  //     }
  //   ];

  //   public chartOptions: any = {
  //     responsive: true
  //   };
  //   public chartClicked(e: any): void { }
  //   public chartHovered(e: any): void { }
}
