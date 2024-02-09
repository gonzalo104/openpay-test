import { Component } from '@angular/core';
import { LogBehaviorService } from 'src/app/features/shared/services/logs/log-behavior.service';

@Component({
  selector: 'app-logs',
  templateUrl: './logs.component.html',
  styleUrls: ['./logs.component.scss']
})
export class LogsComponent {
  logs: any = [];
  constructor(public logBehaviorService: LogBehaviorService) { 
    this.getLogs();
  }

  async getLogs() { 
    const res = await this.logBehaviorService.getLogs();
    this.logs = res;
  }
}
