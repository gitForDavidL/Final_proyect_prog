package co.edu.unbosque.Final_proyect_prog.services;

import co.edu.unbosque.Final_proyect_prog.entities.Owner;
import co.edu.unbosque.Final_proyect_prog.entities.UserApp;
import co.edu.unbosque.Final_proyect_prog.repositories.OwnerImp;
import co.edu.unbosque.Final_proyect_prog.repositories.UserAppImp;
import resources.Pojos.UserAppPOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Random;

public class OwnerService{
    private UserAppImp userAppImp;
    private OwnerImp ownerImp;

    public boolean createOwner(UserAppPOJO user, String name, String address, String neight){
        if (!user.getUserName().isEmpty() && !user.getPassword().isEmpty()
                && !user.getEmail().isEmpty() && !user.getRole().isEmpty()) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("4Citycens_final_proyect");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            userAppImp = new UserAppImp(entityManager);
            ownerImp = new OwnerImp(entityManager);
            int num = 1;
            do{
                num = (int)(Math.random()*(10000+0));
            }while(ownerImp.findById(num)!=null);

            UserApp userApp = new UserApp(user.getUserName(), user.getPassword(), user.getEmail(), user.getRole());
            userAppImp.save(userApp);

            Owner owner = new Owner(userApp,name,address,neight,num);

            ownerImp.save(owner);
            entityManager.close();
            entityManagerFactory.close();
            return true;
        }else{
            return false;
        }
    }
}
