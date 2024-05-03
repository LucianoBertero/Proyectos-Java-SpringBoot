import { JsonPipe } from '@angular/common';
import { Component, OnInit, inject } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { ContactService } from '../services/contact.service';
import { Contact } from '../model/contact.interface';

@Component({
  selector: 'app-contact-form',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule, JsonPipe],
  templateUrl: './contact-form.component.html',
  styleUrl: './contact-form.component.css',
})
export default class ContactFormComponent implements OnInit {
  private fb = inject(FormBuilder);
  private contactService = inject(ContactService);
  private router = inject(Router);
  private route = inject(ActivatedRoute);
  contact?: Contact;

  form?: FormGroup;

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    console.log(id);
    if (id) {
      this.contactService.get(Number(id)).subscribe((contact) => {
        this.contact = contact;
        this.form = this.fb.group({
          name: [contact.name, Validators.required],
          email: [contact.email, Validators.required],
        });
        //Se le carga al formulario
      });
    } else {
      this.form = this.fb.group({
        name: ['', Validators.required],
        email: ['', Validators.required],
      });
    }
  }

  save() {
    const contactForm = this.form!.value;
    console.log(contactForm);

    console.log(this.contact);
    if (this.contact) {
      this.contactService
        .update(Number(this.contact.id), contactForm)
        .subscribe(() => {
          console.log('entro aca');

          this.router.navigate(['/']);
        });
    } else {
      this.contactService.create(contactForm).subscribe(() => {
        this.router.navigate(['/']);
      });
    }
  }
}
