package com.example.y.bookborrow_lendv2;


import android.media.Image;
import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;
import java.util.UUID;
import java.util.ArrayList;

/**
 * Created  on 2/15/19.
 * @since 1.0
 *
 *
 */


public class book {
    private UUID ID;
    private String name = null;
    //private Image photo = null;
    private String author = null;
    private String ISBN = null;
    private Double longitude = 0.0;
    private Double latitude = 0.0;
    private String description = null;
    private String title = null;
    private ArrayList<String> requestedList = new ArrayList<String>();
    private String borrowerName = null;
    private String ownerName = null;
    private String status = "available";
    private Double rating = -1.0;
    private FirebaseDatabase m;
    private DatabaseReference r;

    private Map<String, Boolean> requestList;




    /**
     * A constructor with no parameters
     */
    book(){
        this.ID = UUID.randomUUID();
    }

    book(String id){
        this.ID = UUID.fromString(id);
    };



    /**
     * This constructor is built for writing unit tests, we will use another constructor which doesn't have parameters
     * since there are too many parameters in this constructor
     */
    book(String name, String author, String ISBN, Double longitude, Double latitude, String description
    , String title, Double bookRating, String borrowerName, String ownerName, String status ) {
        this.name = name;
        //this.photo = photo;
        this.author = author;
        this.ISBN = ISBN;
        this.longitude = longitude;
        this.latitude = latitude;
        this.description = description;
        this.title = title;
        //this.bookRating = bookRating;
        this.borrowerName = borrowerName;
        this.ownerName = ownerName;
        this.status = status;
    }


    /**
     * this method set the values that fot from firebase to object
     */

    public void setToFirebase(){
        m = FirebaseDatabase.getInstance();
        r = m.getReference("book/"+this.getID());
        r.child("id").setValue(this.getID());
        r.child("bookRating").setValue(Double.toString(this.rating));
        r.child("name").setValue(this.name);
        r.child("author").setValue(this.author);
        r.child("ISBN").setValue(this.ISBN);
        r.child("longitude").setValue(this.longitude);
        r.child("latitude").setValue(this.latitude);
        r.child("description").setValue(this.description);
        r.child("title").setValue(this.title);
        r.child("borrowerName").setValue(this.borrowerName);
        r.child("ownerName").setValue(this.ownerName);
        r.child("status").setValue(this.status);
    }
    /**
     * @param s
     * this method set a unique id to book
     */

    public void setID(String s) {
        this.ID = UUID.fromString(s);
    }

    /**
     * this method return book ID
     * @return book's ID
     *
     */

    public String getID(){return this.ID.toString();}


    /**
     * this method set a array of books that are requested by users except owner
     * @param list
     */
    public void setRequestedList(ArrayList<String> list) {
        requestedList = list;
    }

    /**
     * this method set the name of user who has borrowed this book
     * @param name
     */

    public void setBorrowerName(String name) {
        borrowerName = name;
    }

    /**
     * this method return the name of user who has borrowed this book
     * @return
     */

    public String getBorrowerName() {
        return borrowerName;
    }

    /**
     * this method set the ISBN code of the book
     * @param ISBN_code
     */

    public void setISBN(String ISBN_code) {
        ISBN = ISBN_code;
    }


    /**
     * this method return the ISBN code of the book
     * @return ISBN_code
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * this method set the description code of the book
     * @param desc
     */

    public void setDescription(String desc) {
        description = desc;
    }


    /**
     * this method return the description of the book
     * @return description
     */
    public String getDescription() {
        return description;
    }


    /**
     * this method set the longitude( one elemente of the coordinate which shows the location) of the book
     * @param longi
     */
    public void setLongitude(Double longi) {
        longitude = longi;
    }

    /**
     * this method return the longitude( one elemente of the coordinate shows the location) of the book
     * @return longi
     */

    public Double getLongitude() {
        return longitude;
    }

    /**
     * this method set the latitude( one elemente of the coordinate  shows the location) of the book
     * @param lati
     */

    public void setLatitude(Double lati) {
        latitude = lati;
    }
    /**
     * this method return the latitude( one elemente of the coordinate  shows the location) of the book
     * @return latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * this method return the array list of books
     * @return a list of books that are requested by users except owner
     */

    public ArrayList<String> getRequestedList() {
        requestedList = new ArrayList<String>(requestList.keySet());
        return requestedList;
    }

    /**
     * set the owner's name of the book
     * @param name
     */

    public void setOwnerName(String name) {
        ownerName = name;
    }

    /**
     * get the owner's name of the book
     * @return
     */


    public String getOwnerName() {
        return ownerName;
    }

    /**
     * set the status of the book to "requested"
     */

    public void setStatusToRequested(){
        this.status = "requested";
        this.setToFirebase();
    }

    /**
     * set the status of the book to "available"
     */


    public void setStatusToAvailable(){
        this.status = "available";
        this.setToFirebase();
    }

    /**
     * set the status of the book to "accepted"
     */

    public void setStatusToAccepted(){
        this.status = "accepted";
        this.setToFirebase();
    }
    /**
     * set the status of the book to "borrowed"
     */

    public void setStatusToborrowed(){
        this.status = "borrowed";
        this.setToFirebase();
    }

    /**
     * return the status of the book
     * @return status
     */

    public String getStatus() {
        return status;
    }

    /**
     * add user's name who has made a request to borrow this book to a list
     * @param name
     */

    public void addRequested(String name) {
        requestedList.add(name);
    }


    /**
     * set title(name) of this book
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * return the name of the book
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * set author's name of this book
     * @param name
     */
    public void setAuthor(String name) {
        this.author = name;
    }

    /**
     * return the author's name of this book
     * @return
     */
    public String getAuthor() {
        return author;
    }

    /**
     * return the book's rating
     * @return rating
     */
    public Double getBookRating(){return rating; }

    /**
     * return the description which contains the book's author, title
     * @return a  author name concatenated with book's title of type string
     */
    public String getDescriptionBundle(){
        return this.getAuthor()+"\n"+this.getName()+"\n";//+this.getISBN();
    }

    /**
     * delete the book from firebase realtime database
     * @return true
     */

    public boolean deleteFromFirebase(){
        m = FirebaseDatabase.getInstance();
        r = m.getReference("book").child(this.getID());
        r.removeValue();

        return true;
    }
}

