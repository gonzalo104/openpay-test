import { Component } from '@angular/core';
import { AuthenticationBehaviorService } from '../../shared/services/auth/authenticcation-behavior.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent {
  constructor(public authenticationBehaviorService: AuthenticationBehaviorService) {}

  ngAfterViewInit(): void {
    const anchors = document.querySelectorAll('.navbar-collapse ul li a');
    anchors?.forEach((anchor) => {
      anchor.addEventListener('click', function () {
        const collapse = document.querySelector('.navbar-collapse');
        const toggler = document.querySelector('.navbar-toggler');
        if (collapse?.classList.contains('show')) {
          collapse.classList.remove('show');
          toggler?.classList.add('collapsed');
        } else {
          collapse?.classList.add('show');
          toggler?.classList.remove('collapsed');
        }
      });
    });
  }


  logout(): void {
    this.authenticationBehaviorService.logout();
  }

}
