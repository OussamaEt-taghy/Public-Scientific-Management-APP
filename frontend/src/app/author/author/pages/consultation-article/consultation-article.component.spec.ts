import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultationArticleComponent } from './consultation-article.component';

describe('ConsultationArticleComponent', () => {
  let component: ConsultationArticleComponent;
  let fixture: ComponentFixture<ConsultationArticleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConsultationArticleComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConsultationArticleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
