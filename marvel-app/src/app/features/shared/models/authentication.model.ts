export interface Authentication {
  token: any;
  username: string;
  message: string;
}

export interface AuthPayload {
  username: string;
  password: string;
}
