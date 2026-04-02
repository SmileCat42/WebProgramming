import { ExtractJwt, Strategy } from 'passport-jwt';
import { PassportStrategy } from '@nestjs/passport';
import { Injectable } from '@nestjs/common';

@Injectable()
export class JwtStrategy extends PassportStrategy(Strategy) {
  constructor() {
    super({
      jwtFromRequest: ExtractJwt.fromAuthHeaderAsBearerToken(), // แอบดูบัตรใน Header
      ignoreExpiration: false,
      secretOrKey: 'MY_SECRET_PINK_DOLL', // ต้องตรงกับใน AuthModule นะจ๊ะ
    });
  }

  async validate(payload: any) {
    // บัตรผ่าน! คืนข้อมูล user กลับไป (จะไปโผล่ใน req.user)
    return { userId: payload.sub, username: payload.username, role: payload.role };
  }
}