import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { HomeRoutingModule } from "./home.routing.module";
import { CharactersComponent } from "./pages/characters/characters.component";
import { LogsComponent } from "./pages/logs/logs.component";
import { ListComponent } from "../../components/list/list.component";
import { SharedModule } from "../../shared/shared.module";
import { ListGroupComponent } from "../../components/list-group/list-group.component";
import { LoaderComponent } from "../../components/loader/loader.component";

@NgModule({
  declarations: [
    CharactersComponent,
    LogsComponent,
    ListComponent,
    ListGroupComponent,
    LoaderComponent,
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    SharedModule,
  ],
  providers: [],
})
export class HomeModule {}
