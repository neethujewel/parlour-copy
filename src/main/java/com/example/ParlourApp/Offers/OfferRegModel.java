package com.example.ParlourApp.Offers;
import com.example.ParlourApp.dto.Parlour;

import com.example.ParlourApp.parlour.ParlourRegModel;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Offers")
public class OfferRegModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "offerName")
    private String offerName;

    @Column(name = "description")
    private String description;

    @Column(name = "Image")
    private byte[]Image;
    @ManyToOne
    @JoinColumn(name = "parlour_id")
    private ParlourRegModel parlour;
    public  OfferRegModel(String offerName,
                          String description, byte[] Image){
        if (description==null){
            this.offerName = offerName;
            this.description = description != null? description:"No Details";
            this.Image=Image;
        }
    }


}
