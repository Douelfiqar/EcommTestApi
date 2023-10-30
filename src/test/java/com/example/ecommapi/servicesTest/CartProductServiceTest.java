package com.example.ecommapi.servicesTest;

import com.example.ecommapi.entities.Cart;
import com.example.ecommapi.entities.CartProduct;
import com.example.ecommapi.entities.Product;
import com.example.ecommapi.entities.User;
import com.example.ecommapi.repositories.CartProductRepo;
import com.example.ecommapi.repositories.CartRepo;
import com.example.ecommapi.repositories.UserRepo;
import com.example.ecommapi.services.ProductService;
import com.example.ecommapi.services.serviceImpl.CartProductServiceImpl;
import com.example.ecommapi.services.serviceImpl.CartServiceImpl;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.*;

public class CartProductServiceTest {
    @Mock
    private CartServiceImpl cartService;
    @Mock
    private ProductService productService;
    @Mock
    private CartProductRepo cartProductRepo;
    @InjectMocks
    private CartProductServiceImpl cartProductService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void addNewProductCart(){
        UUID product_id = UUID.randomUUID();    UUID cart_id = UUID.randomUUID(); UUID user_id = UUID.randomUUID(); UUID cartProduct_id = UUID.randomUUID();

        ArrayList<String> colorsArray = new ArrayList<>();
        colorsArray.add("Black");
        colorsArray.add("Red");

        Product product = Product.builder().id(product_id).reviews(12).name("testName").company("TestCompany").imgURL(new ArrayList<>()).price(1000).featured(true).category("categoryTest").stars(5D).stock(12).description("desc").shipping(true).colors(colorsArray).build();
        User user = User.builder().id(user_id).name("Idriss").username("Rebel").phoneNumber("068521312").email("douidriss@gmail.com").password("123456").build();
        Cart cart = Cart.builder().id(cart_id).user(user).build();


        Collection<String> colors = new ArrayList<>();  colors.add("Red");

       CartProduct cartProduct1 = CartProduct.builder().date(new Date()).product(product).cart(cart).quantity(5).colors(colors).build();

        Mockito.when(productService.getSingleProduct(product_id)).thenReturn(product);
        Mockito.when(cartService.getCart(cart_id)).thenReturn(cart);
        Mockito.when(cartProductRepo.save(cartProduct1)).thenReturn(cartProduct1);

        CartProduct cartProduct = cartProductService.addNewProductCart(cart_id, 5, "Red", product_id);

        assertThat(cartProduct).isNotNull();
        assertThat(cartProduct.getProduct()).isEqualTo(cartProduct1.getProduct());
        assertThat(cartProduct.getCart()).isEqualTo(cartProduct1.getCart());
        assertThat(cartProduct.getQuantity()).isEqualTo(5);
    }
    @Test
    public void testUpdateOldCartProduct() {
        UUID product_id = UUID.randomUUID();    UUID cart_id = UUID.randomUUID(); UUID user_id = UUID.randomUUID();

        UUID cartProduct_id = UUID.randomUUID();
        ArrayList<String> colorsArray = new ArrayList<>();
        colorsArray.add("Black");
        colorsArray.add("Red");


        Product someProduct = Product.builder().id(product_id).reviews(12).name("testName").company("TestCompany").imgURL(new ArrayList<>()).price(1000).featured(true).category("categoryTest").stars(5D).stock(12).description("desc").shipping(true).colors(colorsArray).build();
        User user = User.builder().id(user_id).name("Idriss").username("Rebel").phoneNumber("068521312").email("douidriss@gmail.com").password("123456").build();
        Cart someCart = Cart.builder().id(cart_id).user(user).build();

        int quantity = 5;
        String color = "Yellow";

        // Create a CartProduct that will be returned when findById is called
        Collection<String> existingColors = new ArrayList<>();
        existingColors.add("Red");
        CartProduct existingCartProduct = CartProduct.builder()
                .id(cartProduct_id)
                .date(new Date())
                .product(someProduct)
                .cart(someCart)
                .quantity(5)
                .colors(existingColors)
                .build();

        // Set up the mock to return the existingCartProduct when findById is called
        Mockito.when(cartProductRepo.findById(cartProduct_id)).thenReturn(Optional.of(existingCartProduct));

        // Perform the update
        CartProduct updatedCartProduct = cartProductService.updateOldCartProduct(cartProduct_id, quantity, color);

        // Verify the result
        assertThat(updatedCartProduct).isNotNull();
        assertThat(updatedCartProduct.getQuantity()).isEqualTo(quantity);
        assertThat(updatedCartProduct.getColors()).contains(color);

        // Verify that the mock was called
        Mockito.verify(cartProductRepo).findById(cartProduct_id);
    }
}
