package com.example.ecommapi;

import com.example.ecommapi.entities.Product;
import com.example.ecommapi.repositories.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Collection;

@SpringBootApplication
@AllArgsConstructor
public class EcommApiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EcommApiApplication.class, args);
    }

    private ProductRepo productRepo;

    @Override
    public void run(String... args) throws Exception {
        Product product = new Product();
        product.setName("armchair");
        product.setCategory("bedroom");
        product.setCompany("marcos");
        product.setDescription("Cloud bread VHS hell of banjo bicycle rights jianbing umami mumblecore etsy 8-bit pok pok +1 wolf. Vexillologist yr dreamcatcher waistcoat, authentic chillwave trust fund. Viral typewriter fingerstache pinterest pork belly narwhal. Schlitz venmo everyday carry kitsch pitchfork chillwave iPhone taiyaki trust fund hashtag kinfolk microdosing gochujang live-edge");
        product.setPrice(12599);
        product.setReviews(12);
        product.setStars(2.3);
        product.setStock(3);
        product.setShipping(false);
        Collection<String> colorsCollection = new ArrayList<>();
        colorsCollection.add("#000");
        colorsCollection.add("#00ff00");
        colorsCollection.add("#0000ff");

        product.setColors(colorsCollection);
        Collection<String> imgUrls = new ArrayList<>();
        imgUrls.add("https://www.course-api.com/images/store/product-4.jpeg");
        imgUrls.add("https://www.course-api.com/images/store/extra-product-1.jpeg");
        imgUrls.add("https://www.course-api.com/images/store/extra-product-2.jpeg");
        imgUrls.add("https://www.course-api.com/images/store/extra-product-3.jpeg");
        imgUrls.add("https://www.course-api.com/images/store/extra-product-4.jpeg");
        product.setImgURL(imgUrls);

        productRepo.save(product);
    }
}
