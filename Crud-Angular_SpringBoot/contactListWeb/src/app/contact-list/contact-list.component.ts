import { CommonModule, DatePipe } from '@angular/common';
import { Component, OnInit, inject } from '@angular/core';
import { ContactService } from '../services/contact.service';
import { RouterModule } from '@angular/router';
import { Contact } from '../model/contact.interface';

@Component({
  selector: 'app-contact-list',
  standalone: true,
  imports: [CommonModule, DatePipe, RouterModule],
  templateUrl: './contact-list.component.html',
  styleUrl: './contact-list.component.css',
})
export default class ContactListComponent implements OnInit {
  private contactService = inject(ContactService);
  public contacts: Contact[] = [];
  ngOnInit(): void {
    this.contactService.list().subscribe((contacts) => {
      this.contacts = contacts;
      console.log(contacts);
    });
  }

  deleteContact(contact: Contact) {
    this.contactService.delete(Number(contact.id)).subscribe(() => {
      console.log('se elimino');
    });
    this.contacts = this.contacts.filter((c) => c.id !== contact.id);
    //filtra todo lo que sea igual a la condicion
  }
}
