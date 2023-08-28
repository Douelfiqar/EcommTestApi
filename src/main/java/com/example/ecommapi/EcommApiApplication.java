package com.example.ecommapi;

import com.example.ecommapi.entities.AppRole;
import com.example.ecommapi.entities.Product;
import com.example.ecommapi.entities.User;
import com.example.ecommapi.repositories.AppRoleRepo;
import com.example.ecommapi.repositories.ProductRepo;
import com.example.ecommapi.repositories.UserRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
@SpringBootApplication
@AllArgsConstructor
public class EcommApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommApiApplication.class, args);
    }

    ProductRepo productRepo;
    UserRepo userRepo;
    AppRoleRepo appRoleRepo;

    CommandLineRunner commandLineRunner2(){
        return args -> {
           User user = new User();
            user.setName("vom");
            user.setPassword(new BCryptPasswordEncoder().encode("1234"));
            user.setEmail("cs1.6");
            user.setPhoneNumber("061231");
             user.setUsername("vompiro");
            Collection<AppRole> appRoleCollection2 = new ArrayList<>();
            appRoleCollection2.add(new AppRole("USER"));
            userRepo.save(user);
            User user1 = new User();
            user1.setName("idriss");
            user1.setPassword(new BCryptPasswordEncoder().encode("1234"));
            user1.setEmail("fts");
            user1.setPhoneNumber("0562211");
            user1.setUsername("fc03");
            Collection<AppRole> appRoleCollection = new ArrayList<>();
            appRoleCollection2.add(new AppRole("ADMIN"));
            userRepo.save(user1);
            //appRoleCollection2.add(new AppRole("U"));
            //User user1 = userRepo.findByUsername("fc03");
            //Collection<AppRole> appRoleCollection2 = user1.getAppRoleCollection();
            //appRoleCollection2.add(new AppRole("ADMIN"));
            //userRepo.save(user1);

        };
    }

    CommandLineRunner commandLineRunner(){
        return args -> {
            Product product = new Product();
            product.setName("vase table");
            product.setCategory("office");
            product.setCompany("caressa");
            product.setDescription("Cloud bread VHS hell of banjo bicycle rights jianbing umami mumblecore etsy 8-bit pok pok +1 wolf. Vexillologist yr dreamcatcher waistcoat, authentic chillwave trust fund. Viral typewriter fingerstache pinterest pork belly narwhal. Schlitz venmo everyday carry kitsch pitchfork chillwave iPhone taiyaki trust fund hashtag kinfolk microdosing gochujang live-edge");
            product.setPrice(120999);
            product.setStock(3);
            product.setStars(4.2);
            product.setShipping(true);
            product.setFeatured(true);
            Collection<String> colorCollection = new ArrayList<>();
            colorCollection.add("#0000ff");
            colorCollection.add("#ffb900");
            colorCollection.add("#00ff00");

            product.setColors(colorCollection);

            Collection<String> imageCollection = new ArrayList<>();

            imageCollection.add("https://www.course-api.com/images/store/product-19.jpeg");
            imageCollection.add("https://www.course-api.com/images/store/extra-product-1.jpeg");
            imageCollection.add("https://www.course-api.com/images/store/extra-product-2.jpeg");
            imageCollection.add("https://www.course-api.com/images/store/extra-product-3.jpeg");
            imageCollection.add("https://www.course-api.com/images/store/extra-product-4.jpeg");
            product.setImgURL(imageCollection);
            productRepo.save(product);
    };
    }

    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}
