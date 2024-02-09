import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthenticationBehaviorService } from '../../shared/services/auth/authenticcation-behavior.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {

  constructor(public authenticationBehaviorService: AuthenticationBehaviorService,) {}

  formLogin = new FormGroup({
    username: new FormControl('', [Validators.required, Validators.min(4)]),
    password: new FormControl('', [Validators.required, Validators.min(8)]),
  });

  get disableButton() {
    return this.formLogin.invalid;
  }

  get usenameControl() {
    return this.formLogin.get('username');
  }

  get passwordControl() {
    return this.formLogin.get('password');
  }

  async onSubmit() {
    try {
      console.log("llega", this.formLogin.valid)
      if (!this.formLogin.valid) return;
      const { username, password } = this.formLogin?.value;
      await this.authenticationBehaviorService.login({
        username: username || '',
        password: password || '',
      });
    } catch (error) {
      this.passwordControl?.setErrors({ customError: true });
    }
  }
}
