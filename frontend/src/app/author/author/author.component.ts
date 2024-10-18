import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Component, ViewChild, AfterViewInit, HostListener } from '@angular/core';
import { MatSidenav } from '@angular/material/sidenav';
import { Router, NavigationEnd, ActivatedRoute } from '@angular/router';
import { UntilDestroy, untilDestroyed } from '@ngneat/until-destroy';
import { delay, filter } from 'rxjs/operators';
import { UserStorageService } from 'src/app/auth/Service/user-storage.service';

UntilDestroy()
@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.scss']
})
export class AuthorComponent implements AfterViewInit {
  isMobile: boolean = false;
  username: string | undefined;
  currentYear: number;

  @ViewChild(MatSidenav) sidenav!: MatSidenav;

  @HostListener('window:resize', ['$event'])
  onResize(_event: null) {
    this.isMobile = window.innerWidth < 768;
    if (!this.isMobile && this.sidenav) {
      this.sidenav.mode = 'side';
      this.sidenav.open();
    } else if (this.sidenav) {
      this.sidenav.mode = 'over';
      this.sidenav.close();
    }
  }

  constructor(
    private observer: BreakpointObserver,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.currentYear = new Date().getFullYear();
  }

  ngOnInit() {
    this.onResize(null);
    this.route.params.subscribe(params => {
      this.username = decodeURIComponent(params['username']);
    });
  }
  

  logout(): void {
    UserStorageService.signOut();
    this.router.navigateByUrl('login');
  }
  openSettings(): void {
   
    this.router.navigate(['/settings']);
  }
  ngAfterViewInit() {
    this.observer
      .observe([Breakpoints.Handset, Breakpoints.Tablet])
      .pipe(delay(1), untilDestroyed(this))
      .subscribe((res) => {
        if (res.matches) {
          this.sidenav.mode = 'over';
          this.sidenav.close();
        } else {
          this.sidenav.mode = 'side';
          this.sidenav.open();
        }
      });

    this.router.events
      .pipe(
        untilDestroyed(this),
        filter((e) => e instanceof NavigationEnd)
      )
      .subscribe(() => {
        if (this.isMobile) {
          this.sidenav.close();
        }
      });
  }

  closeSidenavIfMobile() {
    if (this.isMobile) {
      this.sidenav.close();
    }
  }
}