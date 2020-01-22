package model;

import entiteti.Kupci;
import entiteti.Proizvodi;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class Usluge {

    static Transaction tr = null;
    static Kupci k;
    static Session session;

    // Insert new buyer
    public static void unesiKupca(Kupci k) {
        session = Sesija.kreirajSesiju();
        try {
            tr = session.beginTransaction();
            session.persist(k);
            tr.commit();
        } catch (HibernateException e) {
            tr.rollback();
        } finally {
            session.close();
        }
    }

    // Insert shopping(buyer, product)
    public static void unesiKupovinu(Kupci k, Proizvodi p) {
        session = Sesija.kreirajSesiju();
        try {
            tr = session.beginTransaction();
            k.getProizvodis().add(p);
            session.update(k);
            tr.commit();
        } catch (HibernateException e) {
            tr.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Return buyer by e_mail - need it for login
    public static Kupci vratiKupca(String e_mail) {
        session = Sesija.kreirajSesiju();
        try {
            Criteria criteria = session.createCriteria(Kupci.class);
            criteria.add(Restrictions.eq("e_mail", e_mail));
            Kupci k = (Kupci) criteria.uniqueResult();
            return k;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    // Return buyer by ID
    public static Kupci vratiKupca(int id) {
        session = Sesija.kreirajSesiju();
        try {
            Criteria criteria = session.createCriteria(Kupci.class);
            criteria.add(Restrictions.eq("kupciId", id));
            Kupci k = (Kupci) criteria.uniqueResult();
            return k;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    // Return product by name
    public static Proizvodi vratiProizvod(String naziv) {
        session = Sesija.kreirajSesiju();
        try {
            Criteria criteria = session.createCriteria(Proizvodi.class);
            criteria.add(Restrictions.eq("nazivProizvoda", naziv));
            criteria.setMaxResults(1);
            return (Proizvodi) criteria.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    // Return product by ID
    public static Proizvodi vratiProizvod(int id) {
        session = Sesija.kreirajSesiju();
        try {
            Criteria criteria = session.createCriteria(Proizvodi.class);
            criteria.add(Restrictions.eq("proizvodiId", id));
            criteria.setMaxResults(1);
            return (Proizvodi) criteria.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    // Get the list of all products
    public static List<Proizvodi> listajSveProizvode() {
        session = Sesija.kreirajSesiju();
        try {
            Criteria criteria = session.createCriteria(Proizvodi.class);
            return criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public static boolean login(String e_mail, String password) {
        session = Sesija.kreirajSesiju();
        try {
            Criteria criteria = session.createCriteria(Kupci.class);
            criteria.add(Restrictions.eq("e_mail", e_mail));
            criteria.add(Restrictions.eq("password", password));
            Query query = session.createQuery("from Kupci as k where k.e_mail='" + e_mail + "' and k.password='" + password + "'");
            return (!query.list().isEmpty());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }

    // Delete buyer
    public static void obrisi(int id, Kupci k) {
        session = Sesija.kreirajSesiju();
        Proizvodi p = (Proizvodi) session.get(Proizvodi.class, id);
        try {
            tr = session.beginTransaction();
            k.getProizvodis().remove(p);
            session.saveOrUpdate(k.getProizvodis());
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        } finally {
            session.getSessionFactory().close();
        }
    }

    // Update the amount od product
    public static void updateKolicina(int id, int kolicina) {
        session = Sesija.kreirajSesiju();
        try {
            tr = session.beginTransaction();
            Proizvodi p = (Proizvodi) session.get(Proizvodi.class, id);
            int novoStanje = p.getKolicina() - kolicina;
            if (kolicina != 0) {
                p.setKolicina(novoStanje);
                session.merge(p);
                tr.commit();
            }
        } catch (HibernateException ex) {
            tr.rollback();
        } finally {
            session.getSessionFactory().close();
        }
    }

    /* Having a problem with search area at "glavna.jsp", clearly something's wrong with this function, 
    so I left it out... :)
    
      public static List<Proizvodi> find(String name) {
        session = Sesija.kreirajSesiju();
        try {
            Query query = session.createQuery("from Proizvodi as p where lower(p.naziv) like ?");
            query.setString(0, "%" + name + "%");
            return query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }*/
}
