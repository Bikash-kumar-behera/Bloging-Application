import { getDataFromToken } from "@/helpers/getDataFromToken";
import { NextResponse } from "next/server";

export async function POST(request) {
    const response = await getDataFromToken(request);
    return NextResponse.json({
        data: response,
        success: true,
    });
}
