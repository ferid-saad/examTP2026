import 'dart:convert';
import 'package:flutter/foundation.dart' show kIsWeb;
import 'package:http/http.dart' as http;
import '../models/categorie.dart';
import '../models/produit.dart';
import '../models/avis.dart';

class ApiService {
  static final String baseUrl = kIsWeb
      ? 'http://localhost:8090' // Chrome / Web
      : 'http://10.0.2.2:8090'; // Android Emulator

  // Récupérer toutes les catégories
  static Future<List<Categorie>> getCategories() async {
    final response = await http.get(Uri.parse('$baseUrl/api/categories'));
    if (response.statusCode == 200) {
      List<dynamic> data = json.decode(response.body);
      return data.map((e) => Categorie.fromJson(e)).toList();
    }
    throw Exception('Erreur chargement catégories');
  }

  // Récupérer produits par catégorie
  static Future<List<Produit>> getProduitsByCategorie(int categorieId) async {
    final response = await http.get(Uri.parse('$baseUrl/api/produits?categorieId=$categorieId'));
    if (response.statusCode == 200) {
      List<dynamic> data = json.decode(response.body);
      return data.map((e) => Produit.fromJson(e)).toList();
    }
    throw Exception('Erreur chargement produits');
  }

  // Récupérer avis par produit
  static Future<List<Avis>> getAvis(int produitId) async {
    final response = await http.get(Uri.parse('$baseUrl/api/avis/$produitId'));
    if (response.statusCode == 200) {
      List<dynamic> data = json.decode(response.body);
      return data.map((e) => Avis.fromJson(e)).toList();
    }
    throw Exception('Erreur chargement avis');
  }
}
