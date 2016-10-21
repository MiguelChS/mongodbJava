package mongodb;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
public class Mongodb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception {
        try{
            ///coneccion a mongo
            MongoClient mongoCliente = new MongoClient("localhost",27017);
            MongoDatabase  db = mongoCliente.getDatabase("testMiguel");
            //insert en mogo armando un documento
            MongoCollection<Document> collection = db.getCollection("test");
            Document doc = new Document("nombre","Maru");
            doc.append("apellido","Marino");
            collection.insertOne(doc);
            //select de la coleccion de documentos
            MongoCursor<Document> cursor = collection.find().iterator();
            try {
                while (cursor.hasNext()) {
                    System.out.println(cursor.next().toJson());
                }
            } finally {
                cursor.close();
            }
            
        }catch(Exception e){
            System.out.println("error = "+e);
        }
        
    }
    
}
