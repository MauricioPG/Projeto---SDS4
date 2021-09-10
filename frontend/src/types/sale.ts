import { Seller } from "./seller"

export type Sale = {
    id: number;
    visited: number;
    deals: number;
    amount: number;
    date: string;
    seller: Seller;
}

export type SalePage = {
    // ? = opcional
    content?: Sale[];
    totalPages: number;
    totalElements: number;
    size?: number;
    number: number;
    numberOfElements?: number;
    last: boolean,
    first: boolean;
    empty?: boolean
}

export type SaleSum =  {
    sellerName: string;
    sum: number
}

export type SaleSuccess =  {
    sellerName: string;
    visited: number;
    deals: number
}